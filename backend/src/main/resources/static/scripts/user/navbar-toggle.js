document.querySelector(".navbar-burger").addEventListener("click", function () {
    const burger = document.querySelector(".navbar-burger");
    const menu = document.querySelector(".navbar-menu");
    burger.classList.toggle("is-active");
    menu.classList.toggle("is-active");
});