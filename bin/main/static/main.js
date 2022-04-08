fetch('/contacts').then(resp => resp.json()).then(contacts => {
    document.querySelector('#contacts').innerHTML = listContacts(contacts);
});

function listContacts(json) {
    return `${json.map(listContact).join('\n')}`;
};

let listContact = function(contact) {
    return '<p>' + contact.contactId + ": " + contact.name + ": " + contact.email + ": " + contact.phoneNumber + '</p>';
};

function postContact() {
    let contact = {
        "contactId": document.getElementById("contactId").value,
        "name": document.getElementById("name").value,
        "email": document.getElementById("email").value,
        "phoneNumber": document.getElementById("phoneNumber").value
    }
    console.log(contact);
    fetch("/contacts", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
        console.log(result.text());
    }).catch((error) => { console.log(error); })
    fetch('/contacts').then(resp => resp.json()).then(contacts => {
            document.querySelector('#contacts').innerHTML = listContacts(contacts);
        }
    );
}

let button = document.querySelector('button');
button.addEventListener('mouseenter', function() {
    button.textContent = "Enter!";
})