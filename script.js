// Smooth scrolling for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// Form submission handlers
function handleFormSubmit(e) {
    e.preventDefault();
    const email = e.target.querySelector('input[type="email"]').value;

    // Simulate form submission
    showNotification('Thank you! We\'ll notify you when TCM Health launches on Android. 🌿', 'success');
    e.target.reset();

    // In a real app, you would send this to your backend
    console.log('Email registered:', email);
}

// Attach form handlers
const notifyForm = document.getElementById('notify-form');
const ctaForm = document.getElementById('cta-form');

if (notifyForm) {
    notifyForm.addEventListener('submit', handleFormSubmit);
}

if (ctaForm) {
    ctaForm.addEventListener('submit', handleFormSubmit);
}

// Notification system
function showNotification(message, type = 'info') {
    // Remove any existing notifications
    const existingNotification = document.querySelector('.notification');
    if (existingNotification) {
        existingNotification.remove();
    }

    // Create notification element
    const notification = document.createElement('div');
    notification.className = `notification notification-${type}`;
    notification.textContent = message;

    // Style the notification
    Object.assign(notification.style, {
        position: 'fixed',
        top: '100px',
        right: '20px',
        padding: '20px 30px',
        backgroundColor: type === 'success' ? '#4A7C59' : '#8B2635',
        color: 'white',
        borderRadius: '10px',
        boxShadow: '0 4px 20px rgba(0, 0, 0, 0.2)',
        zIndex: '9999',
        fontSize: '16px',
        fontWeight: '500',
        maxWidth: '400px',
        animation: 'slideInRight 0.5s ease',
        fontFamily: "'Noto Sans', sans-serif"
    });

    document.body.appendChild(notification);

    // Auto remove after 4 seconds
    setTimeout(() => {
        notification.style.animation = 'slideOutRight 0.5s ease';
        setTimeout(() => notification.remove(), 500);
    }, 4000);
}

// Add notification animations
const style = document.createElement('style');
style.textContent = `
    @keyframes slideInRight {
        from {
            transform: translateX(400px);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }

    @keyframes slideOutRight {
        from {
            transform: translateX(0);
            opacity: 1;
        }
        to {
            transform: translateX(400px);
            opacity: 0;
        }
    }

    /* Additional Yin Yang dots */
    .yin-yang::before,
    .yin-yang::after {
        box-shadow:
            0 25% 0 12.5% var(--dark-charcoal) inset,
            0 -25% 0 12.5% white inset;
    }
`;
document.head.appendChild(style);

// Header scroll effect
let lastScroll = 0;
const header = document.querySelector('.header');

window.addEventListener('scroll', () => {
    const currentScroll = window.pageYOffset;

    if (currentScroll > 100) {
        header.style.boxShadow = '0 2px 20px rgba(0, 0, 0, 0.1)';
    } else {
        header.style.boxShadow = '0 2px 10px rgba(0, 0, 0, 0.05)';
    }

    lastScroll = currentScroll;
});

// Add scroll reveal animation for elements
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -100px 0px'
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.animation = 'fadeInUp 0.8s ease forwards';
            observer.unobserve(entry.target);
        }
    });
}, observerOptions);

// Observe elements for scroll animations
document.addEventListener('DOMContentLoaded', () => {
    const animateElements = document.querySelectorAll(
        '.feature-card, .element-card, .stat-item'
    );

    animateElements.forEach((el, index) => {
        el.style.opacity = '0';
        el.style.animationDelay = `${index * 0.1}s`;
        observer.observe(el);
    });
});

// Easter egg: Konami code for special animation
let konamiCode = ['ArrowUp', 'ArrowUp', 'ArrowDown', 'ArrowDown', 'ArrowLeft', 'ArrowRight', 'ArrowLeft', 'ArrowRight', 'b', 'a'];
let konamiIndex = 0;

document.addEventListener('keydown', (e) => {
    if (e.key === konamiCode[konamiIndex]) {
        konamiIndex++;
        if (konamiIndex === konamiCode.length) {
            activateEasterEgg();
            konamiIndex = 0;
        }
    } else {
        konamiIndex = 0;
    }
});

function activateEasterEgg() {
    const yinYang = document.querySelector('.yin-yang');
    if (yinYang) {
        yinYang.style.animation = 'spin 2s linear';
        showNotification('Balance achieved! The Qi flows strongly. 🎎', 'success');
    }
}

// Add spin animation for easter egg
const spinStyle = document.createElement('style');
spinStyle.textContent = `
    @keyframes spin {
        from {
            transform: rotate(0deg);
        }
        to {
            transform: rotate(360deg);
        }
    }
`;
document.head.appendChild(spinStyle);

// Console message for developers
console.log(
    '%c🌿 TCM Health 🌿',
    'font-size: 24px; font-weight: bold; color: #8B2635; font-family: serif;'
);
console.log(
    '%cAncient Wisdom, Modern Technology',
    'font-size: 14px; color: #D4AF37;'
);
console.log(
    '%cInterested in joining our team? Contact us!',
    'font-size: 12px; color: #666;'
);
