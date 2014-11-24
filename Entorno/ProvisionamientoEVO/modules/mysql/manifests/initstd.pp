# == Class:  mysql
#
# Configure mysql
#
# == Authors
#
# Ilver Anache <ilver.anache@gmail.com>
class mysql::initstd {
	$root_user = hiera('mysql_root_user', 'root')
	$root_password = hiera('mysql_root_pwd', 'root')
	
	$package_list = ["mysql","mysql-server","mysql-libs"]
	
	package { $package_list:	
		ensure => installed		
	}
	
	file { '/tmp/setpassword.txt':
		content => template('mysql/reset_password.erb'),
		ensure => 'present'
	}
	
	exec { 'setting_default_password':
		path	=>	'/usr/bin:/usr/sbin:/bin:/sbin',
		command => 'mysqld_safe --init-file=init.txt &',
		require => File['/tmp/setpassword.txt']
	}
	
	service { mysqld:		
		enable => "true",
		ensure => "running",
		require => [Exec['setting_default_password'], Package[$package_list]]
	}

	$mysql_port = hiera('mysql_port', 3306)
	firewall { '100 allow tcp access':
		port   => [$mysql_port],
		proto  => tcp,
		action => accept,
	}
		
	file { '/tmp/enable_remote.sql':
		content => template('mysql/enable_remote_access.erb')
	}
	
	exec { 'enable_remote_root_access':
		command => "mysql < /tmp/enable_remote.sql",
		path	=>	'/usr/bin:/usr/sbin:/bin:/sbin',
		require => [File['/tmp/enable_remote.sql'], Service['mysqld']]
	}	
}