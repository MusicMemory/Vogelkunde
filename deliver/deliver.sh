#!/bin/bash
/Library/Java/JavaVirtualMachines/jdk1.8.0_141.jdk/Contents/Home/bin/javapackager -deploy -native dmg -srcfiles ../build/libs/vogelkunde-all-1.0.jar -appclass Main -name Ornithology -outdir deploy -outfile Ornithology -v