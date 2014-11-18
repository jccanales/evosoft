# == Class:  jrockit
#
# Installs JDK 
#
# == Authors
#
# Ilver Anache <ilver.anache@gmail.com>
class jrockit::install8 (
	$install_group=hiera('install_group', 'oinstall'),
	$install_user=hiera('install_user', 'oracle'),
	$java_product_name=hiera('java_product_name',"jrockit-jdk"),
	$java_version=hiera('java_version',"1.6.0_45"), 
	$jrockit_version = hiera('jrockit_version', "R28.2.7-4.1.0"),
	$architecture=hiera('architecture',"ia32")) 
{
	$oracle_home = hiera('oracle_base_home')
	$java_home_link = hiera('java_home_link')

	# Variable Declaration
	$pkg = 	"${java_product_name}-${java_version}-linux-${architecture}.rpm"
	$java_home = "/usr/java/jdk1.8.0_05"
 
	Exec { 
		path 	=> "/usr/bin:/bin:/usr/sbin:/sbin:${java_home}/bin",
		group	=>	$install_group,
		user	=>	$install_user,
	}
	
	exec { 'create_oracle_directory':
		command	=>	"mkdir -p ${oracle_home} && chown ${install_user}:${install_group} ${oracle_home}",
		user	=> 	'root',
	}	
	
	exec { 'install_jdk':
		command => "sudo rpm -ivh /vagrant_data/jdk/jdk-8u5-linux-x64.rpm",
		cwd => $java_home,
		user	=>	$install_user
	}
	
#	file { $java_home_link:
#		ensure => link,
#		target => $java_home,
#		mode => 0755,
#		require => [Exec['install_jdk']]
#	}
#
#	exec { 'install alternatives':
#		command => "alternatives --install /usr/bin/java java ${java_home_link}/bin/java 17065",
#		require => File[$java_home_link],
#		user => 'root'
#	}
#
#	exec { 'set default java alternatives':
#		command => "alternatives --set java ${java_home_link}/bin/java",
#		require => Exec['install alternatives'],
#		user => 'root'
#	}
}