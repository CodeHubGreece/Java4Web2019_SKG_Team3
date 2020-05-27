const userType = localStorage.getItem(LOCAL_STORAGE_USER);
if (userType === "CITIZEN") {
    window.location.replace(ROOT_PATH + "/pages/citizen/index.html");
} else if (userType === "DOCTOR") {
    window.location.replace(ROOT_PATH + "/pages/doctor/index.html");
}