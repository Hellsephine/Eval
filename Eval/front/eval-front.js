let item = [];

function load(){
    fetch("https://data.snx.ovh/API.json")
    .then(function(response){
        return response.json();
    })
    .then(function(data){
        for(let i = 0;i < data.length;i++){
            const post = document.getElementById("CARTE");
            post.innerHTML +='<div class="card my-2"><div class="card-header d-flex"><div class="me-2"><img src="https://i.picsum.photos/id/416/200/200.jpg?hmac=QgMiXqHqKofoCv4h8lkrwRSOkn5Twkh15Dfl9Efvtwo" alt="PP" class="rounded-circle" height="50px" ></div><div class="text-start"><span>@'
            +data[i].author+'</span><br><span class="card-subtitle mb-2 text-muted">'
            +data[i].fullname+'</span></div><div class="ms-auto p-2"><button class="btn btn-link text-decoration-none dropdown-toggle text-primary" type="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-three-dots"></i></i></button><ul class="dropdown-menu dropdown-menu-start"><li><a class="dropdown-item text-muted fw-light"><small>Configuration</small></a></li><li><a class="dropdown-item" href="#">Save</a></li><li><a class="dropdown-item" href="#">Add</a></li><li><a class="dropdown-item" href="#">Report</a></li></ul></div></div><div class="card-body text-start"><p class="card-subtitle"><i class="fw-italic fw-light bi bi-clock text-muted"><small>'
            +data[i].time+'</small></i></p><p class="card-title"><span class="text-primary">'
            +data[i].title+'</span></p><p class="card-text"><small>'
            +data[i].content+'</small></p></div><div class="card-footer text-start"><a href="#" class="card-link text-decoration-none"><i class="bi bi-hand-thumbs-up"> </i>Like</a><a href="#" class="card-link text-decoration-none"><i class="bi bi-chat"> </i>Comment</a><a href="#" class="card-link text-decoration-none"><i class="bi bi-share"> </i>Share</a></div></div>';
        }})
    
}
load();
