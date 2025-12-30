# Deployment Guide for TCM Health Website

This static website can be deployed to various cloud platforms. Choose the option that best fits your needs.

## 🚀 Quick Deploy Options

### Option 1: Netlify (Recommended - Easiest)

#### Method A: Drag & Drop (No CLI needed)
1. Go to [Netlify Drop](https://app.netlify.com/drop)
2. Drag the entire project folder to the drop zone
3. Your site will be live in seconds with a URL like: `https://random-name.netlify.app`
4. Optional: Configure custom domain in Netlify settings

#### Method B: CLI Deployment
```bash
# Install Netlify CLI (if not already installed)
npm install -g netlify-cli

# Login to Netlify
netlify login

# Deploy to production
netlify deploy --prod

# Or create a new site and deploy
netlify deploy --prod --open
```

#### Method C: GitHub Integration
1. Push your code to GitHub
2. Go to [Netlify](https://app.netlify.com)
3. Click "New site from Git"
4. Connect your GitHub repository
5. Deploy settings are already configured in `netlify.toml`

**Deployment config**: Already configured in `netlify.toml`

---

### Option 2: Vercel

#### Method A: CLI Deployment
```bash
# Install Vercel CLI
npm install -g vercel

# Login and deploy
vercel login
vercel --prod
```

#### Method B: GitHub Integration
1. Push your code to GitHub
2. Go to [Vercel](https://vercel.com)
3. Import your GitHub repository
4. Deploy (settings are in `vercel.json`)

**Deployment config**: Already configured in `vercel.json`

---

### Option 3: GitHub Pages

1. Push your code to a GitHub repository
2. Go to repository Settings → Pages
3. Under "Build and deployment":
   - Source: GitHub Actions
4. The workflow in `.github/workflows/deploy.yml` will automatically deploy
5. Your site will be at: `https://yourusername.github.io/tcm`

**Deployment config**: Already configured in `.github/workflows/deploy.yml`

---

### Option 4: Cloudflare Pages

1. Go to [Cloudflare Pages](https://pages.cloudflare.com)
2. Connect your GitHub repository
3. Build settings:
   - Build command: `echo "No build needed"`
   - Build output directory: `/`
4. Deploy

**Free SSL, global CDN, and unlimited bandwidth**

---

### Option 5: AWS S3 + CloudFront

```bash
# Install AWS CLI
pip install awscli

# Configure AWS credentials
aws configure

# Create S3 bucket
aws s3 mb s3://tcmhealth-com

# Enable static website hosting
aws s3 website s3://tcmhealth-com --index-document index.html

# Upload files
aws s3 sync . s3://tcmhealth-com --exclude ".git/*"

# Make files public
aws s3 sync s3://tcmhealth-com s3://tcmhealth-com --acl public-read

# Optional: Set up CloudFront for CDN
```

---

### Option 6: Firebase Hosting

```bash
# Install Firebase CLI
npm install -g firebase-tools

# Login
firebase login

# Initialize Firebase in your project
firebase init hosting

# When prompted:
# - Public directory: . (current directory)
# - Single-page app: No
# - GitHub auto-deploy: Yes (optional)

# Deploy
firebase deploy --only hosting
```

---

### Option 7: Surge.sh (Quick & Simple)

```bash
# Install Surge
npm install -g surge

# Deploy (will prompt for email/password first time)
surge .

# Or deploy to custom domain
surge . tcmhealth.surge.sh
```

---

## 🌐 Custom Domain Setup

After deploying to any platform, you can configure a custom domain:

### For tcmhealth.com:

1. **Purchase domain** from registrar (GoDaddy, Namecheap, Google Domains, etc.)

2. **Configure DNS** with your registrar:
   - For Netlify: Add CNAME record pointing to your Netlify URL
   - For Vercel: Add CNAME record pointing to `cname.vercel-dns.com`
   - For Cloudflare: Use Cloudflare's nameservers

3. **Add custom domain** in your hosting platform's settings

4. **SSL certificate** will be automatically provisioned (free on all platforms)

---

## 📊 Recommended Platform Comparison

| Platform | Difficulty | Free Tier | SSL | CDN | Custom Domain |
|----------|-----------|-----------|-----|-----|---------------|
| **Netlify** | ⭐ Easy | 100GB/month | ✅ | ✅ | ✅ Free |
| **Vercel** | ⭐ Easy | 100GB/month | ✅ | ✅ | ✅ Free |
| **GitHub Pages** | ⭐⭐ Medium | Unlimited | ✅ | ✅ | ✅ Free |
| **Cloudflare** | ⭐⭐ Medium | Unlimited | ✅ | ✅ | ✅ Free |
| **Surge** | ⭐ Easy | 1 project | ✅ | ❌ | ✅ Paid |
| **AWS S3** | ⭐⭐⭐ Hard | 5GB/month | ✅* | ✅* | ✅ Paid |
| **Firebase** | ⭐⭐ Medium | 10GB/month | ✅ | ✅ | ✅ Free |

*Requires additional configuration

---

## 🎯 Our Recommendation

**For beginners**: Use Netlify Drop (drag & drop) - literally 30 seconds to deploy

**For developers**: Use Vercel or Netlify with GitHub integration for automatic deployments

**For free custom domain**: Netlify or Vercel (both include free SSL)

**For maximum control**: AWS S3 + CloudFront

---

## 🔧 Environment Variables

This is a static site with no build process, so no environment variables are needed.

---

## 🚨 Important Notes

1. All platforms listed offer **free SSL certificates**
2. The website is **100% static** - no server-side code
3. Email form submissions are client-side only (add backend later)
4. All major platforms offer **automatic deployments** from Git

---

## 📞 Need Help?

If you encounter issues:
1. Check the platform's documentation
2. Ensure all files (index.html, styles.css, script.js) are uploaded
3. Verify DNS settings if using custom domain
4. Check browser console for errors

Happy deploying! 🚀
