SUMMARY = "applications installing framework"
DESCRIPTION = "Python-based framework for configuring, compiling and installing applications"
HOMEPAGE = "https://waf.io"
SECTION = "console/utils"

# two clause BSD
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://waf-light;beginline=6;endline=30;md5=d24c6f4d54f0156e838f29af79a3bb6b"

DEPENDS = "python3"
DEPENDS_class-native = "waf"

SRC_URI = "git://gitlab.com/ita1024/waf.git"

SRCREV = "3f8bb163290eb8fbfc3b26d61dd04aa5a6a29d4a"
S = "${WORKDIR}/git"

ALTERNATIVE_${PN} = "waf"
ALTERNATIVE_LINK_NAME[waf] = "${bindir}/waf-light"
ALTERNATIVE_TARGET[waf] = "${bindir}/waf-light"

BBCLASSEXTEND = "native nativesdk"
PROVIDES_append_class-native = " waf"
