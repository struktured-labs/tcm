#!/bin/bash

# TCM Health - Quick Deployment Script
# This script helps you deploy the website to various platforms

set -e

echo "🌿 TCM Health - Deployment Assistant 🌿"
echo "========================================"
echo ""

# Color codes
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${BLUE}Choose your deployment platform:${NC}"
echo ""
echo "1) Netlify (Recommended - Easiest)"
echo "2) Vercel"
echo "3) Surge.sh"
echo "4) Create deployment package (ZIP)"
echo "5) Show deployment guide"
echo "6) Exit"
echo ""

read -p "Enter your choice (1-6): " choice

case $choice in
    1)
        echo ""
        echo -e "${GREEN}Deploying to Netlify...${NC}"
        echo ""

        # Check if netlify CLI is installed
        if ! command -v netlify &> /dev/null; then
            echo "Installing Netlify CLI..."
            npm install -g netlify-cli
        fi

        echo "Logging into Netlify..."
        netlify login

        echo ""
        echo "Deploying to production..."
        netlify deploy --prod

        echo ""
        echo -e "${GREEN}✅ Deployment complete!${NC}"
        ;;

    2)
        echo ""
        echo -e "${GREEN}Deploying to Vercel...${NC}"
        echo ""

        # Check if vercel CLI is installed
        if ! command -v vercel &> /dev/null; then
            echo "Installing Vercel CLI..."
            npm install -g vercel
        fi

        echo "Logging into Vercel..."
        vercel login

        echo ""
        echo "Deploying to production..."
        vercel --prod

        echo ""
        echo -e "${GREEN}✅ Deployment complete!${NC}"
        ;;

    3)
        echo ""
        echo -e "${GREEN}Deploying to Surge.sh...${NC}"
        echo ""

        # Check if surge CLI is installed
        if ! command -v surge &> /dev/null; then
            echo "Installing Surge CLI..."
            npm install -g surge
        fi

        echo ""
        echo "Deploying to Surge..."
        surge . tcmhealth.surge.sh

        echo ""
        echo -e "${GREEN}✅ Deployment complete!${NC}"
        echo "Your site is live at: https://tcmhealth.surge.sh"
        ;;

    4)
        echo ""
        echo -e "${GREEN}Creating deployment package...${NC}"
        echo ""

        # Create ZIP file
        zip -r tcm-health-website-$(date +%Y%m%d).zip \
            index.html \
            styles.css \
            script.js \
            README.md \
            netlify.toml \
            vercel.json \
            -x "*.git*" "node_modules/*" "*.zip"

        echo ""
        echo -e "${GREEN}✅ Package created!${NC}"
        echo "File: tcm-health-website-$(date +%Y%m%d).zip"
        echo ""
        echo "Upload this package to:"
        echo "  - Netlify Drop: https://app.netlify.com/drop"
        echo "  - Any web hosting service"
        ;;

    5)
        echo ""
        cat DEPLOYMENT.md
        ;;

    6)
        echo ""
        echo "Goodbye! 👋"
        exit 0
        ;;

    *)
        echo ""
        echo -e "${YELLOW}Invalid choice. Please run the script again.${NC}"
        exit 1
        ;;
esac

echo ""
echo -e "${BLUE}📖 For more deployment options, see DEPLOYMENT.md${NC}"
echo ""
