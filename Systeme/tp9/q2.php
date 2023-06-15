#!/usr/bin/php
<?php
$lines = file("murphy");
foreach($lines as $val){
    $len = strlen($val);
    if($len <= 60){
        echo $val;
    }
}
?>