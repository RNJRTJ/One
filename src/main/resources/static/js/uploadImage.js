let imgPhoto = document.getElementById('imgPhoto');
let inputFile = document.getElementById('inputFile');

inputFile.addEventListener('change', () => {

    if (inputFile.files.length <= 0) {
        return;
    }

    let reader = new FileReader();

    reader.onload = () => {
        imgPhoto.src = reader.result;
    }

    reader.readAsDataURL(inputFile.files[0]);
});