const userType = localStorage.getItem(LOCAL_STORAGE_USER_TYPE);
if (userType === "CITIZEN") {
    console.log(userType);
    window.location.replace(ROOT_PATH + "/pages/citizen/index.html");
} else if (userType === "DOCTOR") {
    console.log(userType);
    window.location.replace(ROOT_PATH + "/pages/doctor/index.html");
}