package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final BizLibraryAccessors laccForBizLibraryAccessors = new BizLibraryAccessors(owner);
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final DeLibraryAccessors laccForDeLibraryAccessors = new DeLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final RedisLibraryAccessors laccForRedisLibraryAccessors = new RedisLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>biz</b>
     */
    public BizLibraryAccessors getBiz() {
        return laccForBizLibraryAccessors;
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>de</b>
     */
    public DeLibraryAccessors getDe() {
        return laccForDeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>io</b>
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of libraries at <b>redis</b>
     */
    public RedisLibraryAccessors getRedis() {
        return laccForRedisLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class BizLibraryAccessors extends SubDependencyFactory {
        private final BizDonviLibraryAccessors laccForBizDonviLibraryAccessors = new BizDonviLibraryAccessors(owner);

        public BizLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>biz.donvi</b>
         */
        public BizDonviLibraryAccessors getDonvi() {
            return laccForBizDonviLibraryAccessors;
        }

    }

    public static class BizDonviLibraryAccessors extends SubDependencyFactory {

        public BizDonviLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jakesrtp</b> with <b>biz.donvi:JakesRTP</b> coordinates and
         * with version reference <b>biz.donvi.jakesrtp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJakesrtp() {
            return create("biz.donvi.jakesrtp");
        }

    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGithubLibraryAccessors laccForComGithubLibraryAccessors = new ComGithubLibraryAccessors(owner);
        private final ComZaxxerLibraryAccessors laccForComZaxxerLibraryAccessors = new ComZaxxerLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github</b>
         */
        public ComGithubLibraryAccessors getGithub() {
            return laccForComGithubLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.zaxxer</b>
         */
        public ComZaxxerLibraryAccessors getZaxxer() {
            return laccForComZaxxerLibraryAccessors;
        }

    }

    public static class ComGithubLibraryAccessors extends SubDependencyFactory {
        private final ComGithubPlanLibraryAccessors laccForComGithubPlanLibraryAccessors = new ComGithubPlanLibraryAccessors(owner);
        private final ComGithubWiiiiam278LibraryAccessors laccForComGithubWiiiiam278LibraryAccessors = new ComGithubWiiiiam278LibraryAccessors(owner);

        public ComGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.plan</b>
         */
        public ComGithubPlanLibraryAccessors getPlan() {
            return laccForComGithubPlanLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.github.wiiiiam278</b>
         */
        public ComGithubWiiiiam278LibraryAccessors getWiiiiam278() {
            return laccForComGithubWiiiiam278LibraryAccessors;
        }

    }

    public static class ComGithubPlanLibraryAccessors extends SubDependencyFactory {
        private final ComGithubPlanPlayerLibraryAccessors laccForComGithubPlanPlayerLibraryAccessors = new ComGithubPlanPlayerLibraryAccessors(owner);

        public ComGithubPlanLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.plan.player</b>
         */
        public ComGithubPlanPlayerLibraryAccessors getPlayer() {
            return laccForComGithubPlanPlayerLibraryAccessors;
        }

    }

    public static class ComGithubPlanPlayerLibraryAccessors extends SubDependencyFactory {
        private final ComGithubPlanPlayerAnalyticsLibraryAccessors laccForComGithubPlanPlayerAnalyticsLibraryAccessors = new ComGithubPlanPlayerAnalyticsLibraryAccessors(owner);

        public ComGithubPlanPlayerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.plan.player.analytics</b>
         */
        public ComGithubPlanPlayerAnalyticsLibraryAccessors getAnalytics() {
            return laccForComGithubPlanPlayerAnalyticsLibraryAccessors;
        }

    }

    public static class ComGithubPlanPlayerAnalyticsLibraryAccessors extends SubDependencyFactory {

        public ComGithubPlanPlayerAnalyticsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plan</b> with <b>com.github.plan-player-analytics:Plan</b> coordinates and
         * with version reference <b>com.github.plan.player.analytics.plan</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlan() {
            return create("com.github.plan.player.analytics.plan");
        }

    }

    public static class ComGithubWiiiiam278LibraryAccessors extends SubDependencyFactory {

        public ComGithubWiiiiam278LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>huskhomes2</b> with <b>com.github.WiIIiam278:HuskHomes2</b> coordinates and
         * with version reference <b>com.github.wiiiiam278.huskhomes2</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHuskhomes2() {
            return create("com.github.wiiiiam278.huskhomes2");
        }

    }

    public static class ComZaxxerLibraryAccessors extends SubDependencyFactory {

        public ComZaxxerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>hikaricp</b> with <b>com.zaxxer:HikariCP</b> coordinates and
         * with version reference <b>com.zaxxer.hikaricp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHikaricp() {
            return create("com.zaxxer.hikaricp");
        }

    }

    public static class DeLibraryAccessors extends SubDependencyFactory {
        private final DeThemoepLibraryAccessors laccForDeThemoepLibraryAccessors = new DeThemoepLibraryAccessors(owner);

        public DeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>de.themoep</b>
         */
        public DeThemoepLibraryAccessors getThemoep() {
            return laccForDeThemoepLibraryAccessors;
        }

    }

    public static class DeThemoepLibraryAccessors extends SubDependencyFactory {

        public DeThemoepLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>minedown</b> with <b>de.themoep:minedown</b> coordinates and
         * with version reference <b>de.themoep.minedown</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMinedown() {
            return create("de.themoep.minedown");
        }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoPapermcLibraryAccessors laccForIoPapermcLibraryAccessors = new IoPapermcLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.papermc</b>
         */
        public IoPapermcLibraryAccessors getPapermc() {
            return laccForIoPapermcLibraryAccessors;
        }

    }

    public static class IoPapermcLibraryAccessors extends SubDependencyFactory {

        public IoPapermcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>paperlib</b> with <b>io.papermc:paperlib</b> coordinates and
         * with version reference <b>io.papermc.paperlib</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPaperlib() {
            return create("io.papermc.paperlib");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgBstatsLibraryAccessors laccForOrgBstatsLibraryAccessors = new OrgBstatsLibraryAccessors(owner);
        private final OrgSpigotmcLibraryAccessors laccForOrgSpigotmcLibraryAccessors = new OrgSpigotmcLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.bstats</b>
         */
        public OrgBstatsLibraryAccessors getBstats() {
            return laccForOrgBstatsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.spigotmc</b>
         */
        public OrgSpigotmcLibraryAccessors getSpigotmc() {
            return laccForOrgSpigotmcLibraryAccessors;
        }

    }

    public static class OrgBstatsLibraryAccessors extends SubDependencyFactory {
        private final OrgBstatsBstatsLibraryAccessors laccForOrgBstatsBstatsLibraryAccessors = new OrgBstatsBstatsLibraryAccessors(owner);

        public OrgBstatsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.bstats.bstats</b>
         */
        public OrgBstatsBstatsLibraryAccessors getBstats() {
            return laccForOrgBstatsBstatsLibraryAccessors;
        }

    }

    public static class OrgBstatsBstatsLibraryAccessors extends SubDependencyFactory {

        public OrgBstatsBstatsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bukkit</b> with <b>org.bstats:bstats-bukkit</b> coordinates and
         * with version reference <b>org.bstats.bstats.bukkit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBukkit() {
            return create("org.bstats.bstats.bukkit");
        }

    }

    public static class OrgSpigotmcLibraryAccessors extends SubDependencyFactory {
        private final OrgSpigotmcSpigotLibraryAccessors laccForOrgSpigotmcSpigotLibraryAccessors = new OrgSpigotmcSpigotLibraryAccessors(owner);

        public OrgSpigotmcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.spigotmc.spigot</b>
         */
        public OrgSpigotmcSpigotLibraryAccessors getSpigot() {
            return laccForOrgSpigotmcSpigotLibraryAccessors;
        }

    }

    public static class OrgSpigotmcSpigotLibraryAccessors extends SubDependencyFactory {

        public OrgSpigotmcSpigotLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.spigotmc:spigot-api</b> coordinates and
         * with version reference <b>org.spigotmc.spigot.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.spigotmc.spigot.api");
        }

    }

    public static class RedisLibraryAccessors extends SubDependencyFactory {
        private final RedisClientsLibraryAccessors laccForRedisClientsLibraryAccessors = new RedisClientsLibraryAccessors(owner);

        public RedisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>redis.clients</b>
         */
        public RedisClientsLibraryAccessors getClients() {
            return laccForRedisClientsLibraryAccessors;
        }

    }

    public static class RedisClientsLibraryAccessors extends SubDependencyFactory {

        public RedisClientsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jedis</b> with <b>redis.clients:jedis</b> coordinates and
         * with version reference <b>redis.clients.jedis</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJedis() {
            return create("redis.clients.jedis");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final BizVersionAccessors vaccForBizVersionAccessors = new BizVersionAccessors(providers, config);
        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final DeVersionAccessors vaccForDeVersionAccessors = new DeVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        private final RedisVersionAccessors vaccForRedisVersionAccessors = new RedisVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.biz</b>
         */
        public BizVersionAccessors getBiz() {
            return vaccForBizVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.de</b>
         */
        public DeVersionAccessors getDe() {
            return vaccForDeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io</b>
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.redis</b>
         */
        public RedisVersionAccessors getRedis() {
            return vaccForRedisVersionAccessors;
        }

    }

    public static class BizVersionAccessors extends VersionFactory  {

        private final BizDonviVersionAccessors vaccForBizDonviVersionAccessors = new BizDonviVersionAccessors(providers, config);
        public BizVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.biz.donvi</b>
         */
        public BizDonviVersionAccessors getDonvi() {
            return vaccForBizDonviVersionAccessors;
        }

    }

    public static class BizDonviVersionAccessors extends VersionFactory  {

        public BizDonviVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>biz.donvi.jakesrtp</b> with value <b>0.14.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJakesrtp() { return getVersion("biz.donvi.jakesrtp"); }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGithubVersionAccessors vaccForComGithubVersionAccessors = new ComGithubVersionAccessors(providers, config);
        private final ComZaxxerVersionAccessors vaccForComZaxxerVersionAccessors = new ComZaxxerVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github</b>
         */
        public ComGithubVersionAccessors getGithub() {
            return vaccForComGithubVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.zaxxer</b>
         */
        public ComZaxxerVersionAccessors getZaxxer() {
            return vaccForComZaxxerVersionAccessors;
        }

    }

    public static class ComGithubVersionAccessors extends VersionFactory  {

        private final ComGithubPlanVersionAccessors vaccForComGithubPlanVersionAccessors = new ComGithubPlanVersionAccessors(providers, config);
        private final ComGithubWiiiiam278VersionAccessors vaccForComGithubWiiiiam278VersionAccessors = new ComGithubWiiiiam278VersionAccessors(providers, config);
        public ComGithubVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.plan</b>
         */
        public ComGithubPlanVersionAccessors getPlan() {
            return vaccForComGithubPlanVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.github.wiiiiam278</b>
         */
        public ComGithubWiiiiam278VersionAccessors getWiiiiam278() {
            return vaccForComGithubWiiiiam278VersionAccessors;
        }

    }

    public static class ComGithubPlanVersionAccessors extends VersionFactory  {

        private final ComGithubPlanPlayerVersionAccessors vaccForComGithubPlanPlayerVersionAccessors = new ComGithubPlanPlayerVersionAccessors(providers, config);
        public ComGithubPlanVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.plan.player</b>
         */
        public ComGithubPlanPlayerVersionAccessors getPlayer() {
            return vaccForComGithubPlanPlayerVersionAccessors;
        }

    }

    public static class ComGithubPlanPlayerVersionAccessors extends VersionFactory  {

        private final ComGithubPlanPlayerAnalyticsVersionAccessors vaccForComGithubPlanPlayerAnalyticsVersionAccessors = new ComGithubPlanPlayerAnalyticsVersionAccessors(providers, config);
        public ComGithubPlanPlayerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.plan.player.analytics</b>
         */
        public ComGithubPlanPlayerAnalyticsVersionAccessors getAnalytics() {
            return vaccForComGithubPlanPlayerAnalyticsVersionAccessors;
        }

    }

    public static class ComGithubPlanPlayerAnalyticsVersionAccessors extends VersionFactory  {

        public ComGithubPlanPlayerAnalyticsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.github.plan.player.analytics.plan</b> with value <b>5.4.1366</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlan() { return getVersion("com.github.plan.player.analytics.plan"); }

    }

    public static class ComGithubWiiiiam278VersionAccessors extends VersionFactory  {

        public ComGithubWiiiiam278VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.github.wiiiiam278.huskhomes2</b> with value <b>2.8.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHuskhomes2() { return getVersion("com.github.wiiiiam278.huskhomes2"); }

    }

    public static class ComZaxxerVersionAccessors extends VersionFactory  {

        public ComZaxxerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.zaxxer.hikaricp</b> with value <b>5.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHikaricp() { return getVersion("com.zaxxer.hikaricp"); }

    }

    public static class DeVersionAccessors extends VersionFactory  {

        private final DeThemoepVersionAccessors vaccForDeThemoepVersionAccessors = new DeThemoepVersionAccessors(providers, config);
        public DeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.de.themoep</b>
         */
        public DeThemoepVersionAccessors getThemoep() {
            return vaccForDeThemoepVersionAccessors;
        }

    }

    public static class DeThemoepVersionAccessors extends VersionFactory  {

        public DeThemoepVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>de.themoep.minedown</b> with value <b>1.7.1-SNAPSHOT</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMinedown() { return getVersion("de.themoep.minedown"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoPapermcVersionAccessors vaccForIoPapermcVersionAccessors = new IoPapermcVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.papermc</b>
         */
        public IoPapermcVersionAccessors getPapermc() {
            return vaccForIoPapermcVersionAccessors;
        }

    }

    public static class IoPapermcVersionAccessors extends VersionFactory  {

        public IoPapermcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.papermc.paperlib</b> with value <b>1.0.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPaperlib() { return getVersion("io.papermc.paperlib"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgBstatsVersionAccessors vaccForOrgBstatsVersionAccessors = new OrgBstatsVersionAccessors(providers, config);
        private final OrgSpigotmcVersionAccessors vaccForOrgSpigotmcVersionAccessors = new OrgSpigotmcVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.bstats</b>
         */
        public OrgBstatsVersionAccessors getBstats() {
            return vaccForOrgBstatsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.spigotmc</b>
         */
        public OrgSpigotmcVersionAccessors getSpigotmc() {
            return vaccForOrgSpigotmcVersionAccessors;
        }

    }

    public static class OrgBstatsVersionAccessors extends VersionFactory  {

        private final OrgBstatsBstatsVersionAccessors vaccForOrgBstatsBstatsVersionAccessors = new OrgBstatsBstatsVersionAccessors(providers, config);
        public OrgBstatsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.bstats.bstats</b>
         */
        public OrgBstatsBstatsVersionAccessors getBstats() {
            return vaccForOrgBstatsBstatsVersionAccessors;
        }

    }

    public static class OrgBstatsBstatsVersionAccessors extends VersionFactory  {

        public OrgBstatsBstatsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.bstats.bstats.bukkit</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBukkit() { return getVersion("org.bstats.bstats.bukkit"); }

    }

    public static class OrgSpigotmcVersionAccessors extends VersionFactory  {

        private final OrgSpigotmcSpigotVersionAccessors vaccForOrgSpigotmcSpigotVersionAccessors = new OrgSpigotmcSpigotVersionAccessors(providers, config);
        public OrgSpigotmcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.spigotmc.spigot</b>
         */
        public OrgSpigotmcSpigotVersionAccessors getSpigot() {
            return vaccForOrgSpigotmcSpigotVersionAccessors;
        }

    }

    public static class OrgSpigotmcSpigotVersionAccessors extends VersionFactory  {

        public OrgSpigotmcSpigotVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.spigotmc.spigot.api</b> with value <b>1.16.5-R0.1-SNAPSHOT</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.spigotmc.spigot.api"); }

    }

    public static class RedisVersionAccessors extends VersionFactory  {

        private final RedisClientsVersionAccessors vaccForRedisClientsVersionAccessors = new RedisClientsVersionAccessors(providers, config);
        public RedisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.redis.clients</b>
         */
        public RedisClientsVersionAccessors getClients() {
            return vaccForRedisClientsVersionAccessors;
        }

    }

    public static class RedisClientsVersionAccessors extends VersionFactory  {

        public RedisClientsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>redis.clients.jedis</b> with value <b>3.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJedis() { return getVersion("redis.clients.jedis"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
