# == Class:  jrockit
#
# Installs JDK 
#
# == Authors
#
# Ilver Anache <ianache@innovaswc.com>
class jrockit (
	$java_product_name=hiera('java_product_name', "jrockit-jdk"),
	$java_version=hiera('java_version',"1.6.0_45"), 
	$jrockit_version = hiera('jrockit_version',"R28.2.7-4.1.0"),
	$architecture=hiera('architecture',"ia32")) 
{
	Class [ 'jrockit::usergroup' ]
	-> class { 
		'jrockit::install':
			architecture => $architecture,
			java_product_name => $java_product_name,
			java_version => $java_version, 
			jrockit_version => $jrockit_version,
			architecture => $architecture
		}
}