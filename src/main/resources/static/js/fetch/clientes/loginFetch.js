function fetchBuscarPaciente() {
    var obj = {
        usuario: document.getElementById('user').value,
        contrasena: document.getElementById('pass').value
    };
    fetch('/validlogin', {
        method: 'POST',
        headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
        body: "json=" + JSON.stringify(obj)
    }).then(response =>//complete
        response.json()
    ).then(data => { //success
        if (data==="Not found") {
            alert("No encontro");
            Swal.fire({
            title: "Error",
            text: "No se encontro el usuario",
            icon: "error",
            confirmButtonText: "Intentar de nuevo"});
        } else{
            s = "/pedirsoporte?q="+data;
            window.location.href = s;
        }
    }).catch(error => { //error
        Swal.fire({
                    title: "Error",
                    text: "Error con la comunicacion al servidor",
                    icon: "error",
                    confirmButtonText: "Intentar de nuevo"});
    });
}

