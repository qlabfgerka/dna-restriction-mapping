# DNA Restriction Mapping

**Application for finding restriction cuts, calculating multi sets and reconstructing restriction cuts**

## Configuration

```
    dna-file algorithm export [cuts]
    
    dna-file: path to the DNA file
    algorithm: b - brute force
               bnb - branch and bound
               bTest - brute force measurements
               bnbTest - branch and bound measurements
    export: y - export to file
            else dont export
    [cuts]: array of restriction cuts 
    
    Example: assets\dna\dna1.txt b y TTCC CTCTCT
```
 
