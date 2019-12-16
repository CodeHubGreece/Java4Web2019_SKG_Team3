async function login(usernameElement, passwordElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";

    let fd = new FormData();
    fd.append( 'username', username);
    fd.append( 'password', password);

    return new Promise((resolve, reject) => {
        $.ajax({
            url: ROOT_PATH + '/login',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function(data){
                resolve(data);
            },
            error: function(error) {
                reject(error);
            }
        });
    });
}

function getLoggedInUser() {
    $.ajax({
        url: ROOT_PATH + '/user',
        processData: false,
        contentType: false,
        type: 'GET',
        success: function(data) {
            localStorage.setItem(LOCAL_STORAGE_USER_TYPE, data.userType);
            if (data.userType === "CITIZEN") {
                window.location.replace(ROOT_PATH + "/pages/citizen/index.html");
            } else {
                window.location.replace(ROOT_PATH + "/pages/doctor/index.html");
            }
        },
        error: function(error) {
            console.error("We had an error!");
        }
    });
}

async function doLogin(username, password) {
    await login(username, password);
    getLoggedInUser();
}

function doRegister(firstNameElement, lastNameElement, emailElement, usernameElement, passwordElement, ssnElement, mobileNumberElement) {
    let firstName = firstNameElement && firstNameElement.value ? firstNameElement.value : "";
    let lastName = lastNameElement && lastNameElement.value ? lastNameElement.value : "";
    let email = emailElement && emailElement.value ? emailElement.value : "";
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";
    let ssn = ssnElement && ssnElement.value ? ssnElement.value : "";
    let mobileNumber = mobileNumberElement && mobileNumberElement.value ? mobileNumberElement.value : "";

    const data = { "firstName": firstName, "lastName": lastName, "email": email, "username": username,
        "password": password, "ssn": ssn, "mobileNumber": mobileNumber };

    $.ajax({
        url: ROOT_PATH + '/register',
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        type: 'POST',
        success: function() {
            localStorage.setItem(LOCAL_STORAGE_USER_TYPE, "CITIZEN");
            window.location.replace(ROOT_PATH + "/pages/citizen/index.html");
        },
        error: function(error) {
            console.error(error);
        }
    });
}