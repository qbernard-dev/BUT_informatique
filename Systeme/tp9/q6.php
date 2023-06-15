#!/usr/bin/php
<?php
$lines = file("demog");
$naiss = 0;
$deces = 0;
foreach($lines as $val){
    $val = rtrim($val);
    $parts = explode(",", "$val");
    if (($parts[0] % 10)== 0){
        $naiss = $naiss + $parts[2];
        $deces = $deces + $parts[3];
    }
}
echo $naiss . "," . $deces . "\n";
?>