$('document').ready(function(){
    const currentUser = JSON.parse(localStorage.getItem(LOCAL_STORAGE_USER));
    const userDetailsParagraphs = document.querySelectorAll("#userDetails > p");
    userDetailsParagraphs[0].innerHTML = currentUser.userFirstName ? userDetailsParagraphs[0].innerHTML + " " + currentUser.userFirstName : userDetailsParagraphs[0].innerHTML + " " + currentUser.firstName;
    userDetailsParagraphs[1].innerHTML = currentUser.userLastName ? userDetailsParagraphs[1].innerHTML + " " + currentUser.userLastName : userDetailsParagraphs[1].innerHTML + " " + currentUser.lastName;
    userDetailsParagraphs[2].innerHTML = currentUser.userUsername ? userDetailsParagraphs[2].innerHTML + " " + currentUser.userUsername :userDetailsParagraphs[2].innerHTML + " " + currentUser.username;
    userDetailsParagraphs[3].innerHTML = currentUser.userEmail ? userDetailsParagraphs[3].innerHTML + " " + currentUser.userEmail : userDetailsParagraphs[3].innerHTML + " " + currentUser.email;
    userDetailsParagraphs[4].innerHTML = currentUser.userMobileNumber ? userDetailsParagraphs[4].innerHTML + " " + currentUser.userMobileNumber : userDetailsParagraphs[4].innerHTML + " " + currentUser.mobileNumber;
    userDetailsParagraphs[5].innerHTML = currentUser.citizenSSN ? userDetailsParagraphs[5].innerHTML + " " + currentUser.citizenSSN : userDetailsParagraphs[5].innerHTML + " " + currentUser.ssn;

    const tableBody = document.querySelector("#table-body");
    const appointments = currentUser.citizenAppointmentDto;

    appointments && appointments.map(function(appointment) {

        const datetime = new Date(appointment.appointmentDate);
        const dateString = datetime.toLocaleDateString(undefined, {
            day : 'numeric',
            month : 'short',
            year : 'numeric'
        });


        const timeString = datetime.toLocaleTimeString(undefined, {
            hour: '2-digit',
            minute: '2-digit'
        });

        let tableRow = document.createElement("tr");

        let row = document.createElement("td");
        row.innerHTML = dateString;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = timeString;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.doctorSpeciality;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.doctorFirstName + " " + appointment.doctorLastName;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.description;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.notes;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = "Edit";
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = "Delete";
        tableRow.appendChild(row);

        tableBody.appendChild(tableRow);
    });
    $.ajax({
        url: ROOT_PATH + '/speciality',
        processData: false,
        contentType: false,
        type: 'GET',
        success: function(data) {
            const specialitySelector = document.querySelector("#speciality");
            const option = document.createElement("option");
            option.text = "Choose a speciality";
            option.value = "";
            specialitySelector.appendChild(option);
            data.map(function(speciality) {
                const option = document.createElement("option");
                option.text = speciality.name;
                option.value = speciality.id;
                specialitySelector.appendChild(option);
            });
        },
        error: function(error) {
            console.error("We had an error!");
        }
    });
});

function getDoctorsBySpeciality() {
    const specialityId = document.querySelector("#speciality").value;
    $.ajax({
        url: ROOT_PATH + '/doctors/speciality/' + specialityId,
        processData: false,
        contentType: false,
        type: 'GET',
        success: function(data) {
            const doctorSelector = document.querySelector(".doctor-selector");
            doctorSelector.setAttribute("style", "visibility: visible;");
            const specialitySelector = document.querySelector("#doctor");
            const option = document.createElement("option");
            option.text = "Choose a doctor";
            option.value = "";
            specialitySelector.appendChild(option);
            data.map(function(doctor) {
                const option = document.createElement("option");
                option.text = doctor.userFirstName + " " + doctor.userLastName;
                option.value = doctor.doctorId;
                specialitySelector.appendChild(option);
            });
        },
        error: function(error) {
            console.error("We had an error!");
        }
    });
}

function showFields() {
    const fields = document.querySelectorAll(".other-selectors");
    fields.forEach(function(field) {
        field.setAttribute("style", "visibility: visible;");
    });
}

function createAppointment(doctorElement, datetimeElement, descriptionElement, notesElement) {
    let doctorId = doctorElement && doctorElement.value ? parseInt(doctorElement.value) : "";
    let datetime = datetimeElement && datetimeElement.value ? datetimeElement.value : "";
    let description = descriptionElement && descriptionElement.value ? descriptionElement.value : "";
    let notes = notesElement && notesElement.value ? notesElement.value : "";
    const currentUser = JSON.parse(localStorage.getItem(LOCAL_STORAGE_USER));

    const data = { doctorId, "citizenId": currentUser.citizenId, appointmentDate: new Date(datetime).getTime(), description, notes };

    $.ajax({
        url: ROOT_PATH + "/appointment",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        type: 'POST',
        success: function(data) {
            document.querySelector('.modal').classList.remove('is-active');
            getLoggedInUser();
        },
        error: function(error) {
            console.error("We had an error!");
            document.querySelector('.modal').classList.remove('is-active');
            getLoggedInUser();
        }
    });

}