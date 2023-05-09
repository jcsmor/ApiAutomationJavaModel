#!/usr/bin/env bash
# This file is sourced to enable WPR
# It enables WPR in the appropriate mode
# and sets the WPR_PID variable for later use
WPR_FILE="$(pwd)/MY_WPR"
cd catapult/web_page_replay_go
go install src/wpr.go
if [ -f ${WPR_FILE} ] ; then
    export WPR_MODE="replay"
    echo "Enabling ${WPR_MODE} mode using existing WPR file: ${WPR_FILE}"
else
    export WPR_MODE="record"
    echo "Enabling ${WPR_MODE} mode using new WPR file: ${WPR_FILE}"
fi
go run src/wpr.go ${WPR_MODE} --http_port=8080 --https_port=8081 /Users/jmoreira/Documents/abp_adwall_automation/MY_WPR
# &> wpr.log & WPR_PID=$!
sleep 30

KEY_HASH=$(openssl x509 -noout -pubkey -in wpr_cert.pem | \
    openssl pkey -pubin -outform der | \
    openssl dgst -sha256 -binary | \
    base64)

WPR_CONFIG="--wpr_cert_hash ${KEY_HASH}"
cd -