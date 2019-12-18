$('document').ready(function(){
    const currentUser = JSON.parse(localStorage.getItem(LOCAL_STORAGE_USER));
    const userDetailsParagraphs = document.querySelectorAll("#userDetails > p");
    userDetailsParagraphs[0].innerHTML = userDetailsParagraphs[0].innerHTML + " " + currentUser.userFirstName;
    userDetailsParagraphs[1].innerHTML = userDetailsParagraphs[1].innerHTML + " " + currentUser.userLastName;
    userDetailsParagraphs[2].innerHTML = userDetailsParagraphs[2].innerHTML + " " + currentUser.userUsername;
    userDetailsParagraphs[3].innerHTML = userDetailsParagraphs[3].innerHTML + " " + currentUser.doctorSpecialityDto.specialityName;

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
            $.ajax({
                url: ROOT_PATH + '/citizen/' + appointment.citizenId,
                processData: false,
                contentType: false,
                type: 'GET',
                success: function(data) {
                    document.querySelector('.modal').classList.add('is-active');
                    const userDetailsParagraphs = document.querySelectorAll("#user-details > p");
                    userDetailsParagraphs[0].innerHTML = "<strong>First name: </strong>" + data.userFirstName;
                    userDetailsParagraphs[1].innerHTML = "<strong>Last name: </strong>" + data.userLastName;
                    userDetailsParagraphs[2].innerHTML = "<strong>Usermame: </strong>" + data.userUsername;
                    userDetailsParagraphs[3].innerHTML = "<strong>Email: </strong>" + data.userEmail;
                    userDetailsParagraphs[4].innerHTML = "<strong>Mobile Number: </strong>" + data.userMobileNumber;
                    userDetailsParagraphs[5].innerHTML = "<strong>SSN: </strong>" + data.citizenSSN;

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
                    appointmentDetailsParagraphs[0].innerHTML = "<strong>Date: </strong>" + dateString;
                    appointmentDetailsParagraphs[1].innerHTML = "<strong>Time: </strong>" + timeString;
                    appointmentDetailsParagraphs[2].innerHTML = "<strong>Description: </strong>" + appointment.description;
                    appointmentDetailsParagraphs[3].innerHTML = "<strong>Notes: </strong>" + appointment.notes;
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

});