
do_unpack_prepend () {
    bb.build.exec_func('restore_shared_folder', d)
}

do_unpack_append () {
    shared = d.getVar("TFA_SHARED_SOURCES")
    if shared and oe.types.boolean(shared):
        # Copy/Paste from kernel class with adaptation to TFA var
        s = d.getVar("S")
        if s[-1] == '/':
            # drop trailing slash, so that os.symlink(tfasrc, s) doesn't use s as directory name and fail
            s=s[:-1]
            tfasrc = d.getVar("STAGING_TFA_DIR")
            if s != tfasrc:
                bb.utils.mkdirhier(tfasrc)
                bb.utils.remove(tfasrc, recurse=True)
                if d.getVar("EXTERNALSRC"):
                    # With EXTERNALSRC S will not be wiped so we can symlink to it
                    os.symlink(s, tfasrc)
                else:
                    import shutil
                    shutil.move(s, tfasrc)
                    os.symlink(tfasrc, s)


}

restore_shared_folder(){
    install -d ${STAGING_TFA_DIR}

}
