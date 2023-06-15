#!/usr/bin/php
<?php
$lines = file("murphy");
foreach($lines as $val){
    $len = strlen($val);
    $val = rtrim($val);
    if($len <= 60){
        echo str_word_count($val)."\n";
    }
}

?>