$('document').ready(function () {


    $('.btn-group .btn-info').on('click', function (event) {

        event.preventDefault();

        var button = $(this)
        var id = button.data('edId')
        var name = button.data('edName')
        var surname = button.data('edSurname')
        var email = button.data('edEmail')
        var password = button.data('edPassword')
        var age = button.data('edAge')
        var roles = button.data('edRoles')
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var myModal = $('#editModal')
        $('.modal-title').text('Изменить пользователя с ID = ' + id)
        $('#editId').val("" + id)
        $('#editName').val(name)
        $('#editSurname').val(surname)
        $('#editEmail').val(email)
        $('#editPassword').val(password)
        $('#editAge').val(age)
        $('#editRoles').val(roles)


        myModal.modal('show')
    });

    $('.table .btn-danger').on('click', function (event) {

        event.preventDefault();

        var delbutton = $(this)
        var id = delbutton.data('delId')
        var name = delbutton.data('delName')
        var surname = delbutton.data('delSurname')
        var email = delbutton.data('delEmail')
        var password = delbutton.data('delPassword')
        var age = delbutton.data('delAge')
        var roles = delbutton.data('delRoles')
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var delModal = $('#deleteModal')
        $('.modal-title').text('Удалить пользователя с ID = ' + id)
        $('#deleteId').val("" + id)
        $('#deleteName').val(name)
        $('#deleteSurname').val(surname)
        $('#deleteEmail').val(email)
        $('#deletePassword').val(password)
        $('#deleteAge').val(age)
        $('#deleteRoles').val(roles)


        delModal.modal('show')
    });

});