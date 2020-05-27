function searchAppointment(fromDateTimeElement, toDateTimeElement, keywordElement) {
    let fromDateTime = fromDateTimeElement && fromDateTimeElement.value ? fromDateTimeElement.value : "";
    let toDateTime = toDateTimeElement && toDateTimeElement.value ? toDateTimeElement.value : "";
    let keyword = keywordElement && keywordElement.value ? keywordElement.value : "";

    const fromDate = new Date(fromDateTime);
    const toDate = new Date(toDateTime);

    const fromDateString = fromDate.toLocaleDateString(undefined, {
        day : '2-digit',
        month : '2-digit',
        year : 'numeric'
    });


    const fromTimeString = fromDate.toLocaleTimeString(undefined, {
        hour: '2-digit',
        minute: '2-digit'
    });

    const toDateString = toDate.toLocaleDateString(undefined, {
        day : '2-digit',
        month : '2-digit',
        year : 'numeric'
    });


    const toTimeString = toDate.toLocaleTimeString(undefined, {
        hour: '2-digit',
        minute: '2-digit'
    });

    const startDate = fromDateString + " " + fromTimeString;
    const endDate = toDateString + " " + toTimeString;

    const data = { startDate, endDate, keyword };

    $.ajax({
        url: ROOT_PATH + "/appointment/doctor/search",
        type: "GET",
        data: data,
        success: function(data) {
            displayResults(data);
        },
        error: function(error) {
            console.error(error);
        }
    });
}

function displayResults(data) {
    const resultsTable = document.querySelector(".table");
    resultsTable.classList.remove("is-hidden");
    const resultsTableBody = document.querySelector("#table-body");

    data.length > 0 && data.map(function(appointment, index) {
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
        row.innerHTML = appointment.citizenFirstName + " " + appointment.citizenLastName;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.description;
        tableRow.appendChild(row);

        row = document.createElement("td");
        row.innerHTML = appointment.notes;
        tableRow.appendChild(row);

        resultsTableBody.appendChild(tableRow);
    });
}