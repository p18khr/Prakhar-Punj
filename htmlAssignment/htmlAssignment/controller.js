  
  function validateName(){
    let x = document.forms["myForm"]["Name"].value;   
    let error = document.getElementById("errorName");        
    if (x == "" || !/^[A-Za-z\s]+$/.test(x)) {
        error.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Name must be filled out using only alphabet letters and whitespace</h5></span>";
      }
      else{
          error.innerHTML="";
      }
  }

  function validateEmail(){
    let y = document.forms["myForm"]["Email"].value;
    let error = document.getElementById("errorEmail");        
    if (y == "" || !/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z\-])+\.)+([a-zA-Z]{2,4})+$/.test(y)) {
        error.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Invalid Email</h5></span>";
      }
      else{
        error.innerHTML="";
    }
  }

  function validateWebsite(){
    let z = document.forms["myForm"]["Website"].value;
    let error = document.getElementById("errorWebsite");
    if (z == "" || (z.match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g)) == null) {
        error.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Invalid Website URL</h5></span>";
      }
      else{
        error.innerHTML="";
    }
  }

  function validateImageLink(){
    let a = document.forms["myForm"]["ImageLink"].value;
    let error = document.getElementById("errorImageLink");
    if (a == "" || (a.match(/\.(jpeg|jpg|gif|png|tiff|psd|pdf|eps|svg|ai|indd|raw)$/) == null)) {
        error.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Invalid Image Link</h5></span>";
      }
      else{
        error.innerHTML="";
    }
  }


function validateForm(){
    let x = document.forms["myForm"]["Name"].value;
    let y = document.forms["myForm"]["Email"].value;
    let z = document.forms["myForm"]["Website"].value;
    let a = document.forms["myForm"]["ImageLink"].value;

    let errorName = document.getElementById("errorName");
    let errorEmail = document.getElementById("errorEmail");
    let errorWebsite = document.getElementById("errorWebsite");
    let errorImageLink = document.getElementById("errorImageLink");
    let errorSubmit = document.getElementById("errorSubmit");
    let errorCheckbox = document.getElementById("errorCheckbox");


    
    
    if(x =="" & y =="" & z == "" & a == ""){
        errorSubmit.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Kindly fill all the fields before submitting</h5></span>";
    }
    else if (x == "") {
        errorName.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Name must be filled out using only alphabet letters and whitespace</h5></span>";
        
      }

    else if (y == "") {
        errorEmail.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Invalid Email</h5></span>";
        
      }
    
    else if (z == "") {
        errorWebsite.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Invalid Website URL</h5></span>";
        
      }
    
    else if (a == "") {
        errorImageLink.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Invalid Image Link</h5></span>";
        
      }
    else{
        var chck = document.getElementById("c1").checked || document.getElementById("c2").checked || 
    document.getElementById("c3").checked;
    if(chck  == false){
        errorCheckbox.innerHTML = "<br><span style='color: red;'>"+
        "<h5>Kindly select atleast one skill</h5></span>";
    }
    else{
        errorCheckbox.innerHTML="";
        errorSubmit.innerHTML="";
        sessionStore();
    }
}
 
    
}


function validRecord(formdata){
     for(let j=0;j<sessionStorage.length;j++){
         const unstringify = JSON.parse(sessionStorage.getItem(j));

         if(unstringify.Email == formdata.Email ||
            unstringify.Website == formdata.Website || unstringify.ImageLink == formdata.ImageLink){
                   error = document.getElementById("errorSubmit");
                   errorSubmit.innerHTML = "<br><span style='color: red;'>"+
                   "<h5>Record Already Exists</h5></span>";
                   return true;
         }
     }
    return false;
}



 let i = 0;
if(sessionStorage.length != 0 ){                     // Global Scope
    i = sessionStorage.length;
} 


window.onload=function(){
    sessionOnLoading();
}

  function sessionOnLoading(){
      for(let x = 0;x<=i;x++){
        const unstringify = JSON.parse(sessionStorage.getItem(x));

        name1 = unstringify.Name;
       email = unstringify.Email;
       website = unstringify.Website;
      imagelink = unstringify.ImageLink;
      gender = unstringify.Gender;
      check = unstringify.Check;
      var table = document.getElementById("mytable");
      var row = table.insertRow(1);
      var cell1 = row.insertCell(0);
      var cell2 = row.insertCell(1);
      cell1.innerHTML = "<br><strong>"+name1+"</strong>"+"<br>"+gender+"<br>"+email+"<br><a>"+website+"</a><br>"+check+"<br><br>";
      cell2.innerHTML = "<img src ="+imagelink+">";

      }
  }

  
function sessionStore(){

    let name = document.forms["myForm"]["Name"].value;
    let email = document.forms["myForm"]["Email"].value;
    let website = document.forms["myForm"]["Website"].value;
    let imagelink = document.forms["myForm"]["ImageLink"].value;
    let gender = document.forms["myForm"]["Gender"].value;

    let button = document.getElementById("add");

    let check = "";
    const checkres = [];

    if(document.getElementById("c1").checked == true){
        checkres.push(document.getElementById("c1").value);
    }
    if(document.getElementById("c2").checked == true){
        checkres.push(document.getElementById("c2").value);
    }
    if(document.getElementById("c3").checked == true){
        checkres.push(document.getElementById("c3").value);
    }

    for(let j=0;j<checkres.length-1;j++){
        check = check+checkres[j]+", ";
    }
    check = check+checkres[checkres.length-1];
    
    const formdata = {Name:name,Email:email,Website:website,ImageLink:imagelink,Gender:gender,Check:check};

    if(validRecord(formdata)){
        return;
    }
    

    sessionStorage.setItem(i,JSON.stringify(formdata));
    
    const unstringify = JSON.parse(sessionStorage.getItem(i));

    name = unstringify.Name;
    email = unstringify.Email;
    website = unstringify.Website;
    imagelink = unstringify.ImageLink;
    gender = unstringify.Gender;
    check = unstringify.Check;

    i++;


  var table = document.getElementById("mytable");
  var row = table.insertRow(1);
  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  cell1.innerHTML = "<br><strong>"+name+"</strong>"+"<br>"+gender+"<br>"+email+"<br>"+"<a>"+website+"</a><br>"+check+"<br><br>";
  cell2.innerHTML = "<img src ="+imagelink+">";


}




