# == Class:  glassfish
#
# Installs Glassfish 
#
# == Authors
#
# Ilver Anache <ilver.anache@gmail.com>
class glassfish::initcustom {

	$install_dir = hiera('install_directory')
	$glassfish_admin_user_pwd = hiera('glassfish_admin_user_pwd')
	$glassfish_version = hiera('glassfish_version')
	$glassfish_admin_port = hiera('glassfish_admin_port')
	$glassfish_admin_user = hiera('glassfish_admin_user')
	$glassfish_http_port = hiera('glassfish_http_port')
	$domain_name = hiera('glassfish_domain','default')
	$oracle_home=hiera('oracle_home','/u01/app/oracle')
	$install_directory = "${oracle_home}/${install_dir}"
		
	Exec {
		path 	=> "/usr/bin:/bin:/usr/sbin:/sbin",
		logoutput  => true,
		timeout => 0,
		user 	=> 'root'
	}
	
	$answer_file = '/tmp/gf_answer.txt'
	file { $answer_file:
		content => template('glassfish/gf_answer.erb')
	}
	
	$install_file = "/vagrant_data/glassfish/ogs-${glassfish_version}-unix.sh"
	file { $install_file:
		ensure => present,
		mode => "+x",
		require => File[$answer_file]
	}
	
	exec { 'create_install_directory': 
		command => "mkdir -p ${install_directory}",
	}
	
	exec { 'install_glassfish':
		command => "sh ${install_file} -a ${answer_file} -l /tmp -s",
		require => [File[$answer_file], File[$install_file], Exec['create_install_directory']]
	}
	
	firewall { '100 allow http access':
		port   => [$glassfish_http_port, $glassfish_admin_port],
		proto  => tcp,
		action => accept
	}
	
	$glassfish_service = "glassfish_${domain_name}"
	$glassfish_service_file = "/etc/init.d/${glassfish_service}"
	file { $glassfish_service_file:
		content => template('glassfish/glassfish_service.erb'),
		mode => "+x",
		owner => root
	}

	$configure_server = '/tmp/configure_server.sh'
	file { $configure_server:
		content => template('glassfish/configure_server.erb')
	}
		
	exec { $configure_server:
		command => "sh ${configure_server}",
		require => [File[$glassfish_service_file], Exec['install_glassfish']]
	}
	
	service { $glassfish_service:
		ensure => running,
		enable => true,
		require => Exec[$configure_server]
	}
	
# copy mysql jar
# /u01/app/oracle/glassfish/glassfish/domains/default/lib/databases/	
}