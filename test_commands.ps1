Invoke-RestMethod -Uri 'http://localhost:8080/api/students' -Method Get

Invoke-RestMethod -Uri 'http://localhost:8080/api/students/{studentId}' -Method Get

$studentData = @{
    firstName = "John"
    lastName = "Doe"
    email = "john.doe@example.com"
    enrollmentDate = "2023-11-22"
    password = "securePassword"
    faculties = "Computer Science"
    enrolled = $true
}

Invoke-RestMethod -Uri 'http://localhost:8080/api/students' -Method Post -Headers @{ "Content-Type" = "application/json" } -Body ($studentData | ConvertTo-Json) 

$updatedStudentData = @{
    firstName = "UpdatedFirstName"
    lastName = "UpdatedLastName"
    email = "updated.email@example.com"
    enrollmentDate = "2023-11-23"
    password = "updatedPassword"
    faculties = "UpdatedFaculty"
    enrolled = $false
}

Invoke-RestMethod -Uri 'http://localhost:8080/api/students/enrolled' -Method Get

Invoke-RestMethod -Uri 'http://localhost:8080/api/students/{studentId}' -Method Put -Headers @{ "Content-Type" = "application/json" } -Body ($updatedStudentData | ConvertTo-Json)

Invoke-RestMethod -Uri 'http://localhost:8080/api/students/{studentId}' -Method Delete

Invoke-RestMethod -Uri 'http://localhost:8080/api/students/' -Method Delete
