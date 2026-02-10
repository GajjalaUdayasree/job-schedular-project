function createJob(){

let task=document.getElementById("task").value;
let payload=document.getElementById("payload").value;
let priority=document.getElementById("priority").value;

fetch("/jobs",{
method:"POST",
headers:{'Content-Type':'application/json'},
body:JSON.stringify({
taskName:task,
payload:payload,
priority:priority
})
})
.then(res=>res.json())
.then(data=>{
alert("Job Created");
loadJobs();
});
}

function loadJobs(){
fetch("/jobs")
.then(res=>res.json())
.then(data=>{
let rows="";
data.forEach(j=>{
rows+=`<tr>
<td>${j.id}</td>
<td>${j.taskName}</td>
<td>${j.priority}</td>
<td>${j.status}</td>
<td>
<button onclick="runJob(${j.id})">Run</button>
<button onclick="deleteJob(${j.id})">Delete</button>
</td>
</tr>`;
});
document.getElementById("jobTable").innerHTML=rows;
});
}

function runJob(id){
fetch("/jobs/run/"+id,{
method:"POST"
})
.then(res=>res.json())
.then(d=>{
alert("Job Completed");
loadJobs();
});
}

function deleteJob(id){
fetch("/jobs/"+id,{
method:"DELETE"
})
.then(res=>res.text())
.then(d=>{
alert("Deleted");
loadJobs();
});
}
