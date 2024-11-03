function fishTank(lengthInCm, widthInCm, heightInCm, percent) {
    const converterFromCmToDm = 0.001;

    const volumeForAquarium = lengthInCm * widthInCm * heightInCm;
    const volumeInLiters = volumeForAquarium * converterFromCmToDm;
    const occupiedSpace = volumeInLiters * (percent / 100);
    const neededLiters = volumeInLiters - occupiedSpace;

    console.log(neededLiters);
}