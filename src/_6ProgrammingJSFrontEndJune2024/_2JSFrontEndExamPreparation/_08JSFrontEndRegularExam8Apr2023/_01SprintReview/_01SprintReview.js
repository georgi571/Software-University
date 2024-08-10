function solve(input) {
    const numberOfElements = Number(input[0]);
    const spiritBoard = [];
    for (let i = 1; i <= numberOfElements; i++) {
        const elements = input[i].split(':');
        let assignee = spiritBoard.find(as => as.name === elements[0]);
        if (assignee !== undefined) {
            const tasks = {
                taskId: elements[1],
                title: elements[2],
                status: elements[3],
                estimatePoints: Number(elements[4]),
            }
            assignee.tasks.push(tasks);
        } else {
            assignee = {
                name: elements[0],
                tasks: [],
            }
            const tasks = {
                taskId: elements[1],
                title: elements[2],
                status: elements[3],
                estimatePoints: Number(elements[4]),
            }
            assignee.tasks.push(tasks);
            spiritBoard.push(assignee);
        }
    }
    for (let i = 1 + numberOfElements; i < input.length; i++) {
        const elements = input[i].split(':');
        const command = elements[0];
        const assigneeName = elements[1];
        const assignee = spiritBoard.find(as => as.name === assigneeName);
        if (command === 'Add New') {
            if (assignee !== undefined) {
                const tasks = {
                    taskId: elements[2],
                    title: elements[3],
                    status: elements[4],
                    estimatePoints: Number(elements[5]),
                }
                assignee.tasks.push(tasks);
            } else {
                console.log(`Assignee ${assigneeName} does not exist on the board!`);
            }
        } else if (command === 'Change Status') {
            const taskIdForChange = elements[2];
            const newStatus = elements[3];
            if (assignee !== undefined) {
                let task = assignee.tasks.find(t => t.taskId === taskIdForChange);
                if (task !== undefined) {
                    task.status = newStatus;
                } else {
                    console.log(`Task with ID ${taskIdForChange} does not exist for ${assigneeName}!`)
                }

            } else {
                console.log(`Assignee ${assigneeName} does not exist on the board!`);
            }
        } else if (command === 'Remove Task') {
            const index = Number(elements[2]);
            if (assignee !== undefined) {
                const task = assignee.tasks[index];
                if (task !== undefined) {
                    assignee.tasks.splice(index, 1);
                } else {
                    console.log(`Index is out of range!`)
                }

            } else {
                console.log(`Assignee ${assigneeName} does not exist on the board!`);
            }
        }
    }
    let toDoTasksTotalPoints = 0;
    let inProgressTasksTotalPoints = 0;
    let codeReviewTasksTotalPoints = 0;
    let doneTasksTotalPoints = 0;
    for (let spirit of spiritBoard) {
        const tasks = spirit.tasks;
        for (let task of tasks) {
            if (task.status === 'ToDo') {
                toDoTasksTotalPoints += task.estimatePoints;
            } else if (task.status === 'In Progress') {
                inProgressTasksTotalPoints += task.estimatePoints;
            } else if (task.status === 'Code Review') {
                codeReviewTasksTotalPoints += task.estimatePoints;
            } else if (task.status === 'Done') {
                doneTasksTotalPoints += task.estimatePoints;
            }
        }
    }
    console.log(`ToDo: ${toDoTasksTotalPoints}pts`);
    console.log(`In Progress: ${inProgressTasksTotalPoints}pts`);
    console.log(`Code Review: ${codeReviewTasksTotalPoints}pts`);
    console.log(`Done Points: ${doneTasksTotalPoints}pts`);
    const allOther = toDoTasksTotalPoints + inProgressTasksTotalPoints + codeReviewTasksTotalPoints;
    if (doneTasksTotalPoints >= allOther) {
        console.log(`Sprint was successful!`);
    } else {
        console.log(`Sprint was unsuccessful...`)
    }
}