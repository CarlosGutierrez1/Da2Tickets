function fetchSolicitarSoporte() {
    var obj = {
        nombreEquipo: document.getElementById('marca').value,
        codigoEquipo: document.getElementById('codigo').value,
        idcreador: document.getElementById('idUsuario').value,
        estado: 0
    };
    fetch('/registrarsoporte', {
        method: 'POST',
        headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
        body: "json=" + JSON.stringify(obj)
    }).then(response =>//complete
        response.json()
    ).then(data => { //success

    }).catch(error => { //error
        alert("error");
    });
}


