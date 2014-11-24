# == Class:  jrockit
#
# Installs JDK 
#
# == Authors
#
# Ilver Anache <ianache@innovaswc.com>
class jrockit::install7 (
	$install_group=hiera('install_group', 'oinstall'),
	$install_user=hiera('install_user', 'oracle'),
	$java_product_name=hiera('java_product_name',"jrockit-jdk"),
	$java_version=hiera('java_version',"1.6.0_45"), 
	$jrockit_version = hiera('jrockit_version', "R28.2.7-4.1.0"),
	$architecture=hiera('architecture',"ia32")) 
{
	$oracle_home = hiera('oracle_home')

	# Variable Declaration
	$pkg = 	"${java_product_name}-${java_version}-linux-${architecture}"
	$java_home = "${oracle_home}/java/${pkg}"
	$java_home_link = "/usr/java/jdk${java_version}"
	$CFG = 'jrockit-silent'
 
	Exec { 
		path 	=> "/usr/bin:/bin:/usr/sbin:/sbin:${java_home}/bin",
		group	=>	$install_group,
		user	=>	$install_user,
	}
	
	exec { 'create_oracle_directory':
		command	=>	"mkdir -p ${java_home} && chown ${install_user}:${install_group} ${java_home}",
		user	=> 	'root',
	}	
	
	exec { 'install_jdk':
		command => "sudo rpm -ivh /vagrant_data/jdk/${pkg}.rpm",
		cwd => $java_home,
		user	=> 	'root',
		require => Exec['create_oracle_directory']
	}
}