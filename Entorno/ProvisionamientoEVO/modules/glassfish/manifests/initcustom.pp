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
	$glassfish_admin_port = hiera('glassfish_admin_port')
	$glassfish_admin_user = hiera('glassfish_admin_user')
	$glassfish_http_port = hiera('glassfish_http_port')
	$domain_name = hiera('glassfish_domain','default')
	$oracle_home=hiera('oracle_home','/u01/app/oracle')
	$install_directory = "${oracle_home}/${install_dir}"
		
	Exec {
		path 	=> "/usr/bin:/bin:/usr/sbin:/sbin",
		logoutput  => true,
		user 	=> 'root'
	}
	
	$answer_file = '/tmp/gf_answer.txt'
	file { $answer_file:
		content => template('glassfish/gf_answer.erb')
	}
	
	$install_file = "/vagrant_data/glassfish/ogs-3.1.2.2-unix.sh"
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
	
#	exec { 'create_service':
#		command => "${install_directory}/bin/asadmin create-service ${domain_name}",
#		require => Exec['install_glassfish']
#	}
}