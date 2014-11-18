# == Class:  jrockit::usergroup
#
# Oracle User & Group to install Oracle Products
#
# == Authors
#
# Ilver Anache <ianache@innovaswc.com>
class jrockit::usergroup (
	$install_primary_group=hiera('install_primary_group','oinstall'),
	$install_secondary_group=hiera('install_secondary_group','dba'),
	$install_user=hiera('install_user','oracle')) {
	
	group { $install_primary_group:
		gid		=>	400,
		ensure	=>	'present',
	}
	
	group { $install_secondary_group:
		gid		=>	401,
		ensure	=>	'present',
	}

	user { $install_user:
		uid	=>	400,
		gid	=>	$install_primary_group, #400,  Primary Group Id
		name	=> $install_user,
		comment	=> '"Oracle Owner"',
		home	=> "/home/${install_user}",
		groups	=>	[$install_secondary_group],
		managehome	=> true,
		shell	=>	'/sbin/nologin',
		ensure	=>	'present',
		require	=>	[Group[$install_primary_group],Group[$install_secondary_group]],
	}	
}