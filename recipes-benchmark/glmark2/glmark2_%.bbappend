FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += " udev waf-light-native apt-native"

SRC_URI_remove = "file://0001-Fix-clang-warnings.patch"

SRCREV = "5e0e448ca2c3a37c0b2c7794bcd73a700f79aa4f"

PACKAGECONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'x11 opengl', 'x11-gl x11-gles2', '', d)} \
                 ${@bb.utils.contains('DISTRO_FEATURES', 'wayland opengl', 'wayland-gles2', '', d)} \
                 drm-gles2"

# use this patch if recipe waf-light-native fails to clone
#SRC_URI_append += " file://0001-fix-replace-with-buildable-waflib-from-gitlab.com.patch "

# use this prepand along with waf-light-native recipe
do_configure_prepend() {
	rm -Rf ${S}/waf ${S}/waflib
	ln -s `which waf-light` ${S}/waf
	ln -s $(dirname `which waf-light`)/waflib ${S}/waflib
}
