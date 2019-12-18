$('document').ready(function(){
    const currentUser = JSON.parse(localStorage.getItem(LOCAL_STORAGE_USER));
    const userDetailsParagraphs = document.querySelectorAll("#userDetails > p");
    userDetailsParagraphs[0].innerHTML = userDetailsParagraphs[0].innerHTML + " " + currentUser.firstName;
    userDetailsParagraphs[1].innerHTML = userDetailsParagraphs[1].innerHTML + " " + currentUser.lastName;
    userDetailsParagraphs[2].innerHTML = userDetailsParagraphs[2].innerHTML + " " + currentUser.username;
    userDetailsParagraphs[3].innerHTML = userDetailsParagraphs[3].innerHTML + " " + currentUser.doctorSpecialityDto["specialityName"];


    const tableBody = document.querySelector("#table-body");
    const appointments = currentUser.doctorAppointmentDto;

    appointments.map(function(appointment) {

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

        tableRow.addEventListener("click", function () {
            console.log(appointment);
            $.ajax({
                url: ROOT_PATH + '/citizen/' + appointment.citizenId,
                processData: false,
                contentType: false,
                type: 'GET',
                success: function(data) {
                    console.log(data);
                    document.querySelector('.modal').classList.add('is-active');
                    const userDetailsParagraphs = document.querySelectorAll("#user-details > p");
                    userDetailsParagraphs[0].innerHTML = userDetailsParagraphs[0].innerHTML + " " + data.userFirstName;
                    userDetailsParagraphs[1].innerHTML = userDetailsParagraphs[1].innerHTML + " " + data.userLastName;
                    userDetailsParagraphs[2].innerHTML = userDetailsParagraphs[2].innerHTML + " " + data.userUsername;
                    userDetailsParagraphs[3].innerHTML = userDetailsParagraphs[3].innerHTML + " " + data.userEmail;
                    userDetailsParagraphs[4].innerHTML = userDetailsParagraphs[4].innerHTML + " " + data.userMobileNumber;
                    userDetailsParagraphs[5].innerHTML = userDetailsParagraphs[5].innerHTML + " " + data.citizenSSN;

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

                    const appointmentDetailsParagraphs = document.querySelectorAll("#appointment-details > p");
                    appointmentDetailsParagraphs[0].innerHTML = appointmentDetailsParagraphs[0].innerHTML + " " + dateString;
                    appointmentDetailsParagraphs[1].innerHTML = appointmentDetailsParagraphs[1].innerHTML + " " + timeString;
                    appointmentDetailsParagraphs[2].innerHTML = appointmentDetailsParagraphs[2].innerHTML + " " + appointment.description;
                    appointmentDetailsParagraphs[3].innerHTML = appointmentDetailsParagraphs[3].innerHTML + " " + appointment.notes;
                }
            })
        });

        let row = document.createElement("td");
        row.innerHTML = dateString;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = timeString;
        tableRow.appendChild(row);


        row = document.createElement("td");
        row.innerHTML = appointment.citizenFirstName + " " + appointment.citizenLastName;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.description;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.notes;
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