const form = document.getElementsByTagName("form")[0]

let arrey = [1, 2, 3]
let myOb = {}

form.addEventListener("submit", e => {

    const passPattern =
      /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.* ).{8,16}$/;

    const { value: fname} = form[0]
    const { value: lname } = form[1];
    const { value: pass } = form[2];
    const { value: cpass } = form[3];

    if (!fname || !lname || !pass || !cpass)
        alert("You have to fill in all the values")
    else if(!passPattern.test(pass))
        alert("Password must have special charater and lenth > 8")
    else if(pass !== cpass)
        alert("The passwords do not correspond")
    else {
        return true

        //const formData = new FormData(form)
        // TheWorld123#Is

        // TODO: change fetch request url and create servlet to handle the action
        // fetch('file.php', { method: 'POST', body: formData })
        //     .then(res => res.json())
        //     .then(data => {
        //         console.log(data)
        //         window.location.href = "php/result.php";
        //     })
        //     .catch(err => {
        //         console.log(err)
        //         alert("Sorry there was an error")
        //     })
    }
    e.preventDefault()

})


// fetch("url") //api for the get request
//   .then((response) => response.json())
//   .then((data) => console.log(data));

