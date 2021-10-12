window.addEventListener('load', function(){
    const formulario = document.querySelector('#add_new_paciente');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = {
            nombre: document.querySelector('#nombre').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value
        };

        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(respose => respose.json())
            .then(data => {
                let succesAlert = '<div class="alert alert-success alert-dismissible">' +
                                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                '<strong></strong> Paciente agregado </div>'

                    document.querySelector('#response').innerHTML = succesAlert;
                    document.querySelector('#response').style.display = "block";
                    resetUploadForm();
        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                             '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                             '<strong> Error intente nuevamente</strong> </div>'

              document.querySelector('#response').innerHTML = errorAlert;
              document.querySelector('#response').style.display = "block";
             resetUploadForm();})
        });

        function resetUploadForm(){
            document.querySelector('#nombre').value = "";
            document.querySelector('#dni').value = "";
            document.querySelector('#fechaIngreso').value  = "";
        }

        (function(){
            let pathname = window.location.pathname;
            if(pathname === "/"){
                document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/listadoPacientes.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })();
        console.log("hizo algo");
});