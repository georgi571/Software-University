function radioCrystals(inputs) {
    const crystal = inputs[0];
    for (let i = 1; i < inputs.length; i++) {
        let currentCrystal = inputs[i];
        console.log(`Processing chunk ${currentCrystal} microns`);
        currentCrystal = cut(crystal, currentCrystal);
        currentCrystal = lap(crystal, currentCrystal);
        currentCrystal = grind(crystal, currentCrystal);
        currentCrystal = etch(crystal, currentCrystal);
        currentCrystal = xRay(crystal, currentCrystal);
        if (crystal === currentCrystal) {
            console.log(`Finished crystal ${crystal} microns`);
        }
    }

    function cut(crystal, currentCrystal) {
        let crystalToCut = currentCrystal;
        let cut = 0;
        while (currentCrystal > crystal) {
            let cutCrystal = crystalToCut / 4;
            if (cutCrystal >= crystal) {
                crystalToCut = cutCrystal;
                cut++;
            } else {
                break;
            }
        }
        if (cut > 0) {
            console.log(`Cut x${cut}`);
            crystalToCut = Math.floor(crystalToCut);
            console.log(`Transporting and washing`);
        }
        return crystalToCut;
    }

    function lap(crystal, currentCrystal) {
        let crystalToLap = currentCrystal;
        let lap = 0;
        while (currentCrystal > crystal) {
            let lapCrystal = crystalToLap * 0.80;
            if (lapCrystal >= crystal) {
                crystalToLap = lapCrystal;
                lap++;
            } else {
                break;
            }
        }
        if (lap > 0) {
            console.log(`Lap x${lap}`);
            crystalToLap = Math.floor(crystalToLap);
            console.log(`Transporting and washing`);
        }
        return crystalToLap;
    }

    function grind(crystal, currentCrystal) {
        let crystalToGrind = currentCrystal;
        let grind = 0;
        while (currentCrystal > crystal) {
            let grindCrystal = crystalToGrind - 20;
            if (grindCrystal >= crystal) {
                crystalToGrind = grindCrystal;
                grind++;
            } else {
                break;
            }
        }
        if (grind > 0) {
            console.log(`Grind x${grind}`);
            console.log(`Transporting and washing`);
        }
        return crystalToGrind;
    }

    function etch(crystal, currentCrystal) {
        let crystalToEtch = currentCrystal;
        let etch = 0;
        while (currentCrystal > crystal) {
            let etchCrystal = crystalToEtch - 2;
            if (etchCrystal >= crystal - 1) {
                crystalToEtch = etchCrystal;
                etch++;
            } else {
                break;
            }
        }
        if (etch > 0) {
            console.log(`Etch x${etch}`);
            console.log(`Transporting and washing`);
        }
        return crystalToEtch;
    }

    function xRay(crystal, currentCrystal) {
        let crystalToXRay = currentCrystal;
        let xRay = 0;
        if (crystalToXRay < crystal) {
            crystalToXRay++;
            xRay++;
        }
        if (xRay > 0) {
            console.log(`X-ray x${xRay}`);
        }
        return crystalToXRay;
    }
}