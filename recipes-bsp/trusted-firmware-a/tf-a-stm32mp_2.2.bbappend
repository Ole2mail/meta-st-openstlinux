
do_unpack_prepend () {
    bb.build.exec_func('restore_shared_folder', d)
}

restore_shared_folder(){
	install -d ${STAGING_TFA_DIR}
}
