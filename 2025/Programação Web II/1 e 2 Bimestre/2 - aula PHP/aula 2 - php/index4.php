<?php
    $a = 1;
    $b = 1;
    $c = 0;

    while($a <= 10){
        while($b <= 10){
            $c = $b * $a;
            echo "$a X $b = $c <br>";
            $b = $b + 1;
        }
        echo "<br>";
        $a = $a + 1;
        $b = 1;
    }
?>