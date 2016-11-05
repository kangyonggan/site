var fontSelect = document.getElementById("font-select");
var themeSelect = document.getElementById("theme-select");
var bookBody = document.getElementById("book-body");

window.onload = function () {
    var fontSize = getCookie("com.kangyonggan.font.size", "22");
    var theme = getCookie("com.kangyonggan.theme", "0");

    for (var i = 0; i < fontSelect.options.length; i++) {
        if (fontSelect.options[i].value == fontSize) {
            fontSelect.options[i].selected = true;
            bookBody.style.fontSize = fontSize + "px";
            break;
        }
    }

    if (theme == "1") {
        for (var i = 0; i < themeSelect.options.length; i++) {
            if (themeSelect.options[i].value == theme) {
                themeSelect.options[i].selected = true;

                var themes = document.getElementsByClassName("theme");
                for (var j = 0; j < themes.length; j++) {
                    themes[j].style.color = '#c3c3c3';
                    themes[j].style.background = '#0f0f0f';
                }
                break;
            }
        }
    }
};

function changeSize(e) {
    setCookie("com.kangyonggan.font.size", e.value);
    bookBody.style.fontSize = e.value + "px";
}

function changeTheme(e) {
    setCookie("com.kangyonggan.theme", e.value);
    if (e.value == "0") {
        location.reload();
    } else {
        var themes = document.getElementsByClassName("theme");
        for (var j = 0; j < themes.length; j++) {
            themes[j].style.color = '#c3c3c3';
            themes[j].style.background = '#0f0f0f';
        }
    }
}