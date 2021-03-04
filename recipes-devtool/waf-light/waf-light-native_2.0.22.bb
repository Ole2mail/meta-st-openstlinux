SUMMARY = "applications installing framework"
DESCRIPTION = "Python-based framework for configuring, compiling and installing applications"
HOMEPAGE = "https://waf.io"
SECTION = "console/utils"

# two clause BSD
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://waf-light;beginline=6;endline=30;md5=d24c6f4d54f0156e838f29af79a3bb6b"

DEPENDS = "python3-native"

SRC_URI = "git://gitlab.com/ita1024/waf.git;protocol=ssh;branch=master"

SRCREV = "3f8bb163290eb8fbfc3b26d61dd04aa5a6a29d4a"
S = "${WORKDIR}/git"

inherit native

BBCLASSEXTEND = "native nativesdk"

inherit update-alternatives

ALTERNATIVE_${PN} = "waf"
ALTERNATIVE_LINK_NAME[waf] = "${D}${bindir}/waf-light"

# install executables and support binary (compiled libraries) to run on the host during build process
do_install() {
	install -d ${D}${bindir}/
	install -c -m 755 ${WORKDIR}/git/waf-light ${D}${bindir}/waf-light
	cp --no-preserve=ownership --preserve=mode,timestamps -R ${WORKDIR}/git/waflib ${D}${bindir}
}

# register executables and support files
FILES_${PN} += "${bindir}/waf-light"
FILES_${PN} += "${bindir}/waflib"

