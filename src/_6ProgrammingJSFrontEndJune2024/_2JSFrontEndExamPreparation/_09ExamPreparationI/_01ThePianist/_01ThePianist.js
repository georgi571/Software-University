function solve(input) {
    const numberOfPieces = Number(input[0]);
    let pieces = [];
    for (let i = 1; i <= numberOfPieces; i++) {
        const elements = input[i].split('|');
        const piece = {
            name: elements[0],
            composer: elements[1],
            key: elements[2],
        }
        pieces.push(piece);
    }
    for (let i = 1 + numberOfPieces; i < input.length; i++) {
        const elements = input[i].split('|');
        const command = elements[0];
        const pieceName = elements[1];
        const piece = pieces.find(p => p.name === pieceName);
        if (command === 'Add') {
            if (piece === undefined) {
                const newPiece = {
                    name: pieceName,
                    composer: elements[2],
                    key: elements[3],
                }
                pieces.push(newPiece);
                console.log(`${newPiece.name} by ${newPiece.composer} in ${newPiece.key} added to the collection!`)
            } else {
                console.log(`${piece.name} is already in the collection!`)
            }
        } else if (command === 'Remove') {
            if (piece !== undefined) {
                pieces = pieces.filter(p => p.name !== pieceName);
                console.log(`Successfully removed ${pieceName}!`)
            } else {
                console.log(`Invalid operation! ${pieceName} does not exist in the collection.`)
            }
        } else if (command === 'ChangeKey') {
            const newKey = elements[2];
            if (piece !== undefined) {
                piece.key = newKey
                console.log(`Changed the key of ${pieceName} to ${newKey}!`)
            } else {
                console.log(`Invalid operation! ${pieceName} does not exist in the collection.`)
            }
        } else if (command === 'Stop') {
            for (let currentPiece of pieces) {
                console.log(`${currentPiece.name} -> Composer: ${currentPiece.composer}, Key: ${currentPiece.key}`);
            }
        }
    }
}