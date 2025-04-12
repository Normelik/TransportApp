import { Link } from 'react-router-dom';
import Navbar from '../components/Navbar';
import './LandingPage.css';

type Props = {
  links: string[];
};

const LandingPage = ({ links }: Props) => {
  return (
    <div>
      <Navbar links={links} />
      <section>
        <h1>👋 Vítejte u mého projektu</h1>
        <p>
          Ahoj! Jsem juniorní vývojář a tento projekt je součástí mé cesty, při
          které se učím programovat a zdokonalovat své dovednosti.
        </p>
        <h1>🚀 Cíl</h1>
        <p>Jedním slovem... VŠE!</p>
        <p>
          Základy jsem pochytil na 9 měsíčním kurzu od Greed Fox Academy. Pak už
          jedu jen samostudium.
        </p>
        <h1>🧠 Co se učím</h1>
        <ul>
          <li>💻 Frontend (React & TypeScript)</li>
          <li>⚙️ Backend (Java & Spring Boot)</li>
        </ul>
        <br />
        <p>
          Už jsem se potkal s CSS, HTML, REST API, Spring Security, JWT, Jira,
          Visual Studio Code, IntelliJ IDEA, JUnit
        </p>
        <h1>🚛 Co tu jednou bude</h1>
        <ul>
          <li>🔒 Přihlášování: účet pro admina, dodavatele, majitele skladu</li>
          <li>
            ✅ Sledování doručení: Zobrazení informací a stavů jednotlivých
            dodávek
          </li>
          <li> 📅 Plánování dodávek: Možnost naplánovat časy příjezdů</li>
          <li> 📄 Digitální dokumenty: Nahrávání a přístup k dodacím listům</li>
          <li> 🔔 Notifikace: Základní systém upozornění na změny stavu</li>
          <li> 📍 Poloha dodávky: aktualní poloha dodávky zobrazená na mapě</li>
        </ul>
        <Link to={{ pathname: './home' }}>
          <button className="enter-button" type="submit">
            Vstoupit
          </button>
        </Link>
      </section>
    </div>
  );
};

export default LandingPage;
