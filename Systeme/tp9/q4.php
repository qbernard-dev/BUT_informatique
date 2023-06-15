#!/usr/bin/php
<?php
$lines = file("prod");
foreach($lines as $val){
    $val = rtrim($val);
    $parts = explode(":", "$val");
    echo "$parts[4] ; $parts[2] ; $parts[0]"."\n";
}
?>