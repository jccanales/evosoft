class glassfish {

	$install_directory = hiera('install_directory')
	$glassfish_admin_user_pwd = hiera('glassfish_admin_user_pwd')
	$glassfish_admin_port = hiera('glassfish_admin_port')
	$glassfish_admin_user = hiera('glassfish_admin_user')
	$glassfish_http_port = hiera('glassfish_http_port')
	$domain_name = hiera('domain_name','default')
	
	
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
		mode => "+x"
	}
	
	exec { 'create_install_directory': 
		command => "mkdir -p ${install_directory}",
	}
	
	exec { 'install_jdk':
		command => 'rpm -i /vagrant_data/jdk/jdk-8u25-linux-x64.rpm',
	}
	
	exec { 'install_glassfish':
		command => "sh ${install_file} -a ${answer_file} -l /tmp -s",
		require => [File[$answer_file], File[$install_file], Exec['install_jdk'], Exec['create_install_directory']]
	}
	
	firewall { '100 allow http access':
		port   => [$glassfish_http_port, $glassfish_admin_port],
		proto  => tcp,
		action => accept
	}
	
	exec { 'create_domain':
		command => "/u01/app/oracle/glassfish/bin/asadmin create-domain ${domain_name}",
		require => Exec['install_glassfish']
	}
}