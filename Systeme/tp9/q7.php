#!/usr/bin/php
<?php
$lines = file("access.log");
$ips = [];
foreach($lines as $val){
    $val = rtrim($val);
    $parts = explode(" ", $val);
    $ips[$parts[0]] = $ips[$parts[0]] + $parts[9];
}
foreach($ips as $ip => $size){
    echo $ip . " ; " . $size."\n";
}