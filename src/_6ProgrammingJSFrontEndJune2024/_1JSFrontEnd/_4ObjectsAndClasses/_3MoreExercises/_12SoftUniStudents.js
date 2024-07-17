function softUniStudents(input) {
    const courses = {};
    for (let inputElement of input) {
        if (inputElement.includes(': ')) {
            const courseName = inputElement.split(': ')[0];
            const capacity = parseInt(inputElement.split(': ')[1]);
            if (!courses.hasOwnProperty(courseName)) {
                courses[courseName] = {
                    capacity: 0,
                    students: []
                };
            }
            courses[courseName].capacity += capacity;
        } else if (inputElement.includes(' with email ')) {
            const username = inputElement.split('[')[0];
            const credits = inputElement.split('[')[1].split(']')[0];
            const email = inputElement.split(' with email ')[1].split(' joins ')[0];
            const courseName = inputElement.split(' with email ')[1].split(' joins ')[1];
            if (courses.hasOwnProperty(courseName) && courses[courseName].students.length < courses[courseName].capacity) {
                courses[courseName].students.push({username, email, credits});
            }
        }
    }
    Object.entries(courses)
        .sort((a, b) => b[1].students.length - a[1].students.length)
        .forEach(([courseName, courseInfo]) => {
            const placesLeft = courseInfo.capacity - courseInfo.students.length;
            console.log(`${courseName}: ${placesLeft} places left`);
            courseInfo.students
                .sort((a, b) => b.credits - a.credits)
                .forEach(student => {
                    console.log(`--- ${student.credits}: ${student.username}, ${student.email}`);
                });
        });
}
