class mysql {
	$package_list = ["mysql","mysql-server","mysql-libs"]
	
	package { $package_list:
	
		ensure => installed
		
	}
	
	service { mysqld:
		
		enable => "true",
		ensure => "running"
	
	}
	
}