#!/usr/bin/php
<?php
$lines = file("demog");
foreach($lines as $val){
    $val = rtrim($val);
    $parts = explode(",", "$val");
    $solde = $parts[2] - $parts[3];
    $taux_nat = $parts[2] / $parts[1] * 1000;
    $taux_mort = $parts[3] / $parts[1] * 1000;
    echo "$solde ;" . round($taux_nat,2) . "% ; " . round($taux_mort,2)."%"."\n" ;
}
?>