# == Class:  jrockit
#
# Installs JDK 
#
# == Authors
#
# Ilver Anache <ianache@innovaswc.com>
class jrockit::install (
	$install_group=hiera('install_primary_group', 'oinstall'),
	$install_user=hiera('install_user', 'oracle'),
	$java_product_name=hiera('java_product_name',"jrockit-jdk"),
	$java_version=hiera('java_version',"1.6.0_45"), 
	$jrockit_version = hiera('jrockit_version', "R28.2.7-4.1.0"),
	$architecture=hiera('architecture',"ia32")) 
{
	$oracle_home = hiera('oracle_base_home')
	$java_home_link = hiera('java_home_link')
	$CFG = 'jrockit-silent'

	# Variable Declaration
	$pkg = 	"${java_product_name}${java_version}-${jrockit_version}-linux-${architecture}"
	$java_home = "${oracle_home}/jvm/${pkg}"
 
	Exec { 
		path 	=> "/usr/bin:/bin:/usr/sbin:/sbin:${java_home}/bin",
		group	=>	$install_primary_group,
		user	=>	$install_user,
	}
	
	File {
		group	=>	$install_primary_group,
		owner	=>	$install_user,
	}
	
	exec { 'create_oracle_directory':
		command	=>	"mkdir -p ${oracle_home} && chown oracle:${install_primary_group} ${oracle_home}",
		user	=> 	'root',
	}
	
	file {"${CFG}.xml":
		ensure => 	present,
		name   => 	"/tmp/${CFG}.xml",
		mode   => 	'0644',
		content => 	template("jrockit/${CFG}.erb"),
		require	=>	Exec['create_oracle_directory']
	}
	
	exec { 'make_executable':
		command	=>	"chmod +x /vagrant_data/jdk/${pkg}.bin",
		user	=>	'root',
	}

	exec {'install-jrockit':
		creates   => $java_home,
		command   => "/vagrant_data/jdk/${pkg}.bin -mode=silent -silent_xml=/tmp/${CFG}.xml -log=/tmp/${pkg}.log",
		logoutput => true,
		timeout   => 0,
		require   => [File["${CFG}.xml"], Exec['make_executable']]
	}

	file { $java_home_link:
		ensure => link,
		target => $java_home,
		mode => 0755,
		require => [Exec['install-jrockit']]
	}

	exec { 'install alternatives':
		command => "alternatives --install /usr/bin/java java ${java_home_link}/bin/java 17065",
		require => File[$java_home_link],
		user => 'root'
	}

	exec { 'set default java alternatives':
		command => "alternatives --set java ${java_home_link}/bin/java",
		require => Exec['install alternatives'],
		user => 'root'
	}
}